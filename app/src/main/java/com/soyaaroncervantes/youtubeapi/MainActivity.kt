package com.soyaaroncervantes.youtubeapi

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.soyaaroncervantes.youtubeapi.databinding.ActivityMainBinding

const val API_KEY = "AIzaSyCWiKYC5q9sHRHLC31b1knLD-ul7CQrZ44"

class MainActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
  private lateinit var binding: ActivityMainBinding
  private lateinit var youTubePlayerView: YouTubePlayerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate( layoutInflater )
    youTubePlayerView = binding.youtubePlayerView
    youTubePlayerView.initialize( API_KEY, this )
    setContentView( binding.root )
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if ( resultCode == 1 ) {
      youtubePlayerVideo()
    }
  }

  override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
    if( !p2 ) { p1?.cueVideo("RytH1k3-moc") }
  }

  override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
    if (p1?.isUserRecoverableError == true) {
      p1.getErrorDialog(this, 1).show()
    } else {
      Toast.makeText(this, "Error al cargar el reporductor de YouTube", Toast.LENGTH_SHORT ).show()
    }
  }

  fun youtubePlayerVideo(): YouTubePlayer.Provider {
    return youTubePlayerView
  }

}