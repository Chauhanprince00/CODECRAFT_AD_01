package com.example.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var data:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btn0.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"0")
        }
        binding.btn1.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"1")
        }
        binding.btn2.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"2")
        }
        binding.btn3.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"3")
        }
        binding.btn4.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"4")
        }
        binding.btn5.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"5")
        }
        binding.btn6.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"6")
        }
        binding.btn7.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"7")
        }
        binding.btn8.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"8")
        }
        binding.btn9.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"9")
        }

        binding.btnDot.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+".")
        }
        binding.btnAc.setOnClickListener { 
            binding.inputtext.setText("")
            binding.textoutput.setText("")
        }
        binding.btnDevide.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"/")
        }

        binding.btnPlus.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"+")
        }
        binding.btnModule.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"%")
        }
        binding.btnMinus.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"-")
        }
        binding.btnMultiplication.setOnClickListener {
            data = binding.inputtext.text.toString()
            binding.inputtext.setText(data+"*")
        }

        binding.btnEqual.setOnClickListener {
            data = binding.inputtext.text.toString()
            if (data.isNotEmpty()) {
                val context: Context = Context.enter()
                context.optimizationLevel = -1
                try {
                    val scope: Scriptable = context.initStandardObjects()
                    val result = context.evaluateString(scope, data, "JavaScript", 1, null)
                    binding.textoutput.text = Context.toString(result)
                } catch (e: Exception) {
                    Toast.makeText(this, "Invalid Expression", Toast.LENGTH_SHORT).show()
                } finally {
                    Context.exit()
                }
            }
        }










    }
}