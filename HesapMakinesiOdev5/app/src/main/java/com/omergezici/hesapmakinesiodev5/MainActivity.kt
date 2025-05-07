package com.omergezici.hesapmakinesiodev5

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.omergezici.hesapmakinesiodev5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
 var tutucu1=""
 var tutucu2=""
 var islem1=0
    var sum=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    binding.button0.setOnClickListener {
        tutucu1="${tutucu1+"0"}"
        binding.hesap.text=tutucu1
    }
        binding.button1.setOnClickListener {
            tutucu1="${tutucu1+"1"}"
            binding.hesap.text=tutucu1
        }
        binding.button2.setOnClickListener {
            tutucu1="${tutucu1+"2"}"
            binding.hesap.text=tutucu1
        }
        binding.button3.setOnClickListener {
            tutucu1="${tutucu1+"3"}"
            binding.hesap.text=tutucu1
        }
        binding.button4.setOnClickListener {
            tutucu1="${tutucu1+"4"}"
            binding.hesap.text=tutucu1
        }
        binding.button5.setOnClickListener {
            tutucu1="${tutucu1+"5"}"
            binding.hesap.text=tutucu1
        }
        binding.button6.setOnClickListener {
            tutucu1="${tutucu1+"6"}"
            binding.hesap.text=tutucu1
        }
        binding.button7.setOnClickListener {
            tutucu1="${tutucu1+"7"}"
            binding.hesap.text=tutucu1
        }
        binding.button8.setOnClickListener {
            tutucu1="${tutucu1+"8"}"
            binding.hesap.text=tutucu1
        }
        binding.button9.setOnClickListener {
            tutucu1="${tutucu1+"9"}"
            binding.hesap.text=tutucu1
        }
        binding.buttonC.setOnClickListener {
            tutucu1=""
            binding.hesap.text=tutucu1
        }
        binding.buttonarti.setOnClickListener {
            tutucu1="${tutucu1+"+"}"
            binding.hesap.text=tutucu1






        }
        binding.buttoncarpi.setOnClickListener {
            tutucu1 = binding.hesap.text.toString()
            islem1*=tutucu1.toInt()
            tutucu1=""
            binding.hesap.text="${islem1}"

        }
        binding.buttonbolu.setOnClickListener {
            tutucu1 = binding.hesap.text.toString()
            islem1=tutucu1.toInt()
            binding.hesap.text="${tutucu1}/${tutucu2}"
            tutucu1=""

            binding.hesap.text="${islem1}"

        }
        binding.buttoneksi.setOnClickListener {
            islem1-= tutucu1.toInt()
            tutucu1=""
            binding.hesap.text=tutucu1
            binding.hesap.text="${islem1}"

        }
        binding.buttonesit.setOnClickListener {
            sum=0
            val liste = split(binding.hesap.text.toString())
            for (l in liste){
                sum+=l
            }
            binding.hesap.text="${sum}"
            tutucu1=sum.toString()
            binding.hesap.text=tutucu1
        }


    }

fun split(ayak:String):List<Int>{
    val allNumbersString=ayak.split("+")
    var intList= mutableListOf<Int>()
    for (number in allNumbersString){
        var numberI= number.toInt()
        intList.add(numberI)

    }



   return intList
}


}