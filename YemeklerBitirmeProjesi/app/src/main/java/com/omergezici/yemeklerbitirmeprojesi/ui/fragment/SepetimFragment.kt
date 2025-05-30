package com.omergezici.yemeklerbitirmeprojesi.ui.fragment
import android.animation.Animator
import com.omergezici.yemeklerbitirmeprojesi.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.omergezici.yemeklerbitirmeprojesi.databinding.FragmentSepetimBinding
import com.omergezici.yemeklerbitirmeprojesi.ui.viewmodel.SepetimViewModel
import com.omergezici.yemeklerbitirmeprojesi.ui.viewmodel.UrunDetayViewModel



class SepetimFragment : Fragment() {
    private lateinit var viewModel : SepetimViewModel
    private lateinit var binding: FragmentSepetimBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSepetimBinding.inflate(inflater, container, false)
        //başlangıçta resim görünmemesi için
        binding.imageView2.visibility = View.INVISIBLE
        //butona tıklanınca animasyon başlat
        binding.buttonSepetOnayla.setOnClickListener {
            //eski yöntem
//            val animasyon = AnimationUtils.loadAnimation(requireContext(), R.anim.anim_sepet)
//            binding.imageView2.startAnimation(animasyon)

            binding.lottieAnimationView.setAnimation("anim_sepet.json")
            binding.lottieAnimationView.visibility = View.VISIBLE
            binding.lottieAnimationView.playAnimation()
            binding.lottieAnimationView.apply {
                    setAnimation("anim_sepet.json")
                    visibility = View.VISIBLE
                    playAnimation()

                    addAnimatorListener(object : Animator.AnimatorListener {
                        override fun onAnimationStart(animation: Animator) {}
                        override fun onAnimationEnd(animation: Animator) {
                            visibility = View.GONE  // animasyon bitince gizle
                        }

                        override fun onAnimationCancel(animation: Animator) {}
                        override fun onAnimationRepeat(animation: Animator) {}

                    })
                }
            }

            return binding.root
        }

    }
