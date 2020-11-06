package com.example.utssemester5soal2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_fak.*

class detailfakultas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_fak)
        var intentThatStartedThisActivity = getIntent()
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            var imgF = intentThatStartedThisActivity.getIntExtra(Intent.EXTRA_TEXT, 0)
            var nameF =
                    intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TITLE)
            var deskF =
                    intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
            var deskS =
                    intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_SUBJECT)
            var partWeb = intentThatStartedThisActivity.getStringExtra((Intent.ACTION_PICK))
            var emailF = intentThatStartedThisActivity.getStringExtra((Intent.ACTION_CALL))
            gambar_detail.setImageResource(imgF)
            nama_detail.text = nameF
            deskripsi_detail.text = deskF
            deskripsipendek_detail.text = deskS
            web.text = partWeb
            email.text = emailF
            web.setOnClickListener{
                bukaweb(partWeb)
            }
            email.setOnClickListener {
                sendEmail(emailF)
            }
        }
    }

    private fun sendEmail(emailF: String?) {
        val mailIntent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "text/plain"

        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailF))
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Jangan dibalas")
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Test email")
        startActivity(Intent.createChooser(mailIntent, "Select Client"))
    }

    private fun bukaweb(url: String?) {
        val showWebActivity = Intent(this, webfakultas::class.java)
        showWebActivity.putExtra(Intent.ACTION_VIEW, url)
        startActivity(showWebActivity)
    }

}