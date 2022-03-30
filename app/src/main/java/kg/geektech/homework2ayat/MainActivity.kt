package kg.geektech.homework2ayat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil.*
import kg.geektech.homework2ayat.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = mutableListOf(
        "https://i.pinimg.com/originals/13/ee/00/13ee00c35210ee27c9ec9acb49c218a5.jpg",
        "http://pm1.narvii.com/7198/783e413cd30567e37336446985577c3685f0ee1cr1-1920-1080v2_uhq.jpg",
        "https://art-assorty.ru/wp-content/uploads/2019/02/52323254.jpg",
        "https://www.youloveit.ru/uploads/posts/2018-07/1532030980_youloveit_ru_star_vs_the_forces_of_evil_season4.jpg",
        "https://date-release.info/wp-content/uploads/2019/03/3.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRandom.setOnClickListener {
            val randomUrl = Random.nextInt(list.size)
            val randomElement = list[randomUrl]
            binding.iwStar.glide(randomElement)
        }

        binding.btnSubmit.setOnClickListener {
            val text = binding.etUrl.text.toString()
            if (isHttpUrl(text) || isHttpsUrl(text)
                && isValidUrl(text)
            ) {
                showToast("Правильно!")
                list.add(text)
                binding.iwStar.glide(text)
                binding.etUrl.setText("")
            } else {
                showToast("Укажите правильно ссылку")
            }
        }
    }
}