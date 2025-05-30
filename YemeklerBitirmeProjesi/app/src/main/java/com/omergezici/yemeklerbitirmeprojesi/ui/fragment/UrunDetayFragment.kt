package com.omergezici.yemeklerbitirmeprojesi.ui.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.omergezici.yemeklerbitirmeprojesi.R
import com.omergezici.yemeklerbitirmeprojesi.databinding.FragmentUrunDetayBinding
import com.omergezici.yemeklerbitirmeprojesi.ui.viewmodel.UrunDetayViewModel


class UrunDetayFragment : Fragment() {

    private lateinit var viewModel: UrunDetayViewModel
    private var sayi=0
    private lateinit var binding: FragmentUrunDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding=FragmentUrunDetayBinding.inflate(inflater,container,false)
        var toplam_ucret:String


        val bundle:UrunDetayFragmentArgs by navArgs()
        val gelenYemek=bundle.Yemek
        resimGoster(gelenYemek.yemek_resim_adi,binding)
        binding.textViewUcret.text="₺ ${gelenYemek.yemek_fiyat}"

       binding.imageButtonarttir.setOnClickListener {
           arttir()
           toplam_ucret=(gelenYemek.yemek_fiyat.toInt()*sayi).toString()
           binding.textViewToplamUcret.text=" ₺ $toplam_ucret"
       }

        binding.imageButtonAzalt.setOnClickListener {
            azalt()
            toplam_ucret=(gelenYemek.yemek_fiyat.toInt()*sayi).toString()
            binding.textViewToplamUcret.text=" ₺ $toplam_ucret"
        }
         binding.imageButtonKapat.setOnClickListener{
             Navigation.findNavController(it).navigate(R.id.anasayfayaGecis)
         }
         binding.buttonSepeteEkle.setOnClickListener {
             Navigation.findNavController(it).navigate(R.id.urundensepete)


         }

        return binding.root
    }
fun arttir(){

    sayi++
    binding.textViewAdetSayi.text=sayi.toString()
}
    fun azalt(){
        if (sayi>0){
            sayi--
            binding.textViewAdetSayi.text=sayi.toString()
        }


    }

fun resimGoster(resim_isim:String,binding: FragmentUrunDetayBinding){
    val url=("http://kasimadalan.pe.hu/yemekler/resimler/$resim_isim")
    Glide.with(requireContext()).load(url).override(300,300).into(binding.imageViewYemekResim)
}

}