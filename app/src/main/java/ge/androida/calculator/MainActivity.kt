package ge.androida.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ge.androida.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var operand: Double = 0.0
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun onNumberClick(view: View) {
        if (view is Button) {
            val result = binding.tvResult.text.toString()
            if (view.text == "." && result.contains(".")) {
                return
            }
            val btn = view.text.toString()
            val sum = result + btn
            binding.tvResult.text = sum
        }
    }

    fun onOperatorClicked(view: View) {
        if (view is Button) {
            operator = view.text.toString()
            val result = binding.tvResult.text.toString()
            if (result.isNotEmpty()) {
                operand = result.toDouble()
            }
            binding.tvResult.text = ""
        }
    }

    fun onEqualsClicked(view: View) {
        val secOperator = binding.tvResult.text.toString()
        var second = 0.0
        if (secOperator.isNotEmpty()) {
            second = secOperator.toDouble()
        }
        when (operator) {
            "+" -> binding.tvResult.text = (operand + second).toString()
            "-" -> binding.tvResult.text = (operand - second).toString()
            "*" -> binding.tvResult.text = (operand * second).toString()
            "/" -> binding.tvResult.text = (operand / second).toString()
            "%" -> binding.tvResult.text = (operand % second).toString()
        }
    }

    fun onClearClicked(view: View) {
        binding.tvResult.text = ""
        operand = 0.0
        operator = ""
    }

    fun onDeleteClicked(view: View) {
        var text = binding.tvResult.text.toString()
        if (text.isNotEmpty())
            text = text.substring(0, text.length - 1)
        binding.tvResult.text = text
    }

}