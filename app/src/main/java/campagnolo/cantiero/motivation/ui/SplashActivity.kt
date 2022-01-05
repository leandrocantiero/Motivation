package campagnolo.cantiero.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import campagnolo.cantiero.motivation.R
import campagnolo.cantiero.motivation.infra.Motivation
import campagnolo.cantiero.motivation.infra.Preferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mSharedPreferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mSharedPreferences = Preferences(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        btnContinue.setOnClickListener(this)
        verifyName()
    }

    private fun verifyName() {
        val name = mSharedPreferences.getString(Motivation.key.PERSON_NAME)
        if (name != "")
            startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnContinue) {
            handleContinue()
        }
    }

    private fun handleContinue() {
        val name = editName.text.toString()

        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
            mSharedPreferences.storeString(Motivation.key.PERSON_NAME, name)
        } else {
            Toast.makeText(this, getString(R.string.informe_seu_nome), Toast.LENGTH_SHORT).show()
        }
    }
}