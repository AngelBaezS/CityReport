package com.upiicsa.cityreport.ui.incidencias

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.upiicsa.cityreport.data.Incidencia
import com.upiicsa.cityreport.databinding.FragmentIncidenciasListBinding

class IncidenciasListFragment : Fragment() {

    private var _binding: FragmentIncidenciasListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIncidenciasListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón de regresar al fragment anterior en la pila de navegación
        binding.btnVolver.setOnClickListener {
            findNavController().popBackStack()
        }

        // Datos de ejemplo para probar la vista y el Adapter
        val listaIncidencias = listOf(
            Incidencia(
                titulo = "Bache profundo en Av. Té",
                descripcion = "Bache peligroso sobre el carril derecho justo frente al acceso de UPIICSA.",
                fecha = "20/09/2026",
                estado = "Pendiente"
            ),
            Incidencia(
                titulo = "Falla de luminaria en el parque",
                descripcion = "Lámpara pública parpadea y deja la esquina sin iluminación por las noches.",
                fecha = "19/09/2026",
                estado = "En proceso"
            ),
            Incidencia(
                titulo = "Fuga de agua potable en banqueta",
                descripcion = "Fuga constante de agua limpia que emana de una toma domiciliaria.",
                fecha = "18/09/2026",
                estado = "Resuelto"
            ),
            Incidencia(
                titulo = "Semáforo descompuesto",
                descripcion = "Semáforo en luz amarilla fija en el cruce de Av. Ferrocarril y Sur 157.",
                fecha = "17/09/2026",
                estado = "Pendiente"
            ),
            Incidencia(
                titulo = "Basura acumulada en contenedor",
                descripcion = "El contenedor público se encuentra desbordado de residuos.",
                fecha = "16/09/2026",
                estado = "En proceso"
            )
        )

        binding.tvTotalIncidencias.text = "${listaIncidencias.size} incidencias registradas"

        // Configuración del RecyclerView
        binding.rvIncidencias.layoutManager = LinearLayoutManager(requireContext())
        binding.rvIncidencias.adapter = IncidenciaAdapter(listaIncidencias)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
