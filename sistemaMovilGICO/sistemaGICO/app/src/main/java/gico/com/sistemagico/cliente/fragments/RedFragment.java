package gico.com.sistemagico.cliente.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import gico.com.sistemagico.R;
import gico.com.sistemagico.generalGICO;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText campoNombre, campoCedula, campoCelular, campoTelefono, campoMail, campoCredito, campoDireccion;
    Button btnIngresar;
    ProgressDialog progreso;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    StringRequest stringRequest;

    public RedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RedFragment newInstance(String param1, String param2) {
        RedFragment fragment = new RedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_red, container, false);

        campoCedula = (EditText) vista.findViewById(R.id.etCedula);
        campoCelular = (EditText) vista.findViewById(R.id.etCelular);
        campoCredito = (EditText) vista.findViewById(R.id.etCredito);
        campoDireccion = (EditText) vista.findViewById(R.id.etDireccion);
        campoMail = (EditText) vista.findViewById(R.id.etMail);
        campoNombre = (EditText) vista.findViewById(R.id.etNombre);
        campoTelefono = (EditText) vista.findViewById(R.id.etTelefono);
        btnIngresar = (Button) vista.findViewById(R.id.btnIngresarCliente);

        request = Volley.newRequestQueue(getContext());

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarServicioWeb();
            }
        });

        return vista;
    }

    private void cargarServicioWeb() {
        progreso = new ProgressDialog(getContext());
        progreso.setMessage("Cargando...");
        progreso.show();

        String url = "http://"+((generalGICO) getActivity().getApplicationContext()).getDireccionIP()+":8080/GICO-AD/webresources/client/managementMovilClient";

        Map<String, String> params = new HashMap<>();
        String clientMType = "1";
        String clientId = "0";
        String clientCi = campoCedula.getText().toString();
        String clientName = campoNombre.getText().toString();
        String clientPhone = campoTelefono.getText().toString();
        String clientCell = campoCelular.getText().toString();
        String clientMail = campoMail.getText().toString();
        String clientCredit = campoCredito.getText().toString();
        String clientAddress = campoDireccion.getText().toString();

        params.put("clientMType", clientMType);
        params.put("clientId", clientId);
        params.put("clientCi", clientCi);
        params.put("clientName", clientName);
        params.put("clientPhone", clientPhone);
        params.put("clientCell", clientCell);
        params.put("clientMail", clientMail);
        params.put("clientCredit", clientCredit);
        params.put("clientAddress", clientAddress);

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = null;

        jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String resultado = "";
                try {
                    resultado = response.getString("message");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (resultado.trim().equalsIgnoreCase("Exito")) {
                    campoCedula.setText("");
                    campoNombre.setText("");
                    campoTelefono.setText("");
                    campoCelular.setText("");
                    campoMail.setText("");
                    campoCredito.setText("");
                    campoDireccion.setText("");
                    progreso.hide();
                    Toast.makeText(getContext(), "Se agrego el nuevo cliente", Toast.LENGTH_SHORT).show();
                    //Log.d("Ingreso", "Error Respuesta en JSON: " + response);
                } else {
                    progreso.hide();
                    Toast.makeText(getContext(), "Problemas con la conexion", Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getContext(), "" + error + "", Toast.LENGTH_SHORT).show();
                progreso.hide();
                Log.d("Ingreso", "Error Respuesta en JSON: " + error.getMessage());
            }
        });
        request.add(jsonObjectRequest);
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
