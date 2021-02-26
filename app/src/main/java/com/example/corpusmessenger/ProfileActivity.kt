package com.example.corpusmessenger

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //particleView = findViewById(R.id.particleView)
        val twitterImageUrl = "https://image.flaticon.com/icons/png/512/220/220233.png"
        val facebookImageUrl = "https://image.flaticon.com/icons/png/512/124/124010.png"
        val instagramImageUrl = "https://image.flaticon.com/icons/png/512/174/174855.png"

        val user = LatestMessagesActivity.currentUser
        supportActionBar?.title = user?.username
        Picasso.get().load(user?.profileImageUrl).into(user_details_profile_picture_imageview)

        Picasso.get().load(twitterImageUrl).into(twitter_logo)
        Picasso.get().load(facebookImageUrl).into(facebook_logo)
        Picasso.get().load(instagramImageUrl).into(instagram_logo)

        user_details_username_textview.text = user?.username

        twitter_logo.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/")))
        }

        facebook_logo.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/")))
        }

        instagram_logo.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/")))
        }
    }
}