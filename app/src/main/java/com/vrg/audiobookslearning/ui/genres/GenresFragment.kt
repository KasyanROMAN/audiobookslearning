package com.vrg.audiobookslearning.ui.genres

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.vrg.audiobookslearning.R
import com.vrg.audiobookslearning.databinding.FragmentGenresBinding
import com.vrg.audiobookslearning.model.GenresItem


class GenresFragment : Fragment() {

    private var _binding: FragmentGenresBinding? = null
    private val binding get() = _binding!!
    lateinit var genresAdapter: GenresAdapter


    val genresList: MutableList<GenresItem> = mutableListOf(
        GenresItem("Фантастика,фентезі", R.drawable.genres_image2),
        GenresItem("Психологія, філософія", R.drawable.genres_image),
        GenresItem("Роман,проза", R.drawable.genres_image3),
        GenresItem("Дитективи,трилери...", R.drawable.genre_image4),
        GenresItem("Дитективи,трилери...", R.drawable.genre_image5),
        GenresItem("Дитективи,трилери...", R.drawable.genre_image6),
        GenresItem("Дитективи,трилери...", R.drawable.genre_image7),
        GenresItem("Дитективи,трилери...", R.drawable.genre_image8),
        GenresItem("Дитективи,трилери...", R.drawable.genre_image9),
        GenresItem("Дитективи,трилери...", R.drawable.genre_image10)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            _binding = FragmentGenresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        genresAdapter = GenresAdapter()
        binding.idRVCourses.adapter = genresAdapter
        genresAdapter.updateList(genresList)


        binding.searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                genresAdapter.updateList(genresList.filter { newText?.lowercase()?.let { it1 ->
                    it.name?.contains(
                        it1
                    )
                } == true })
                return false
            }


        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}