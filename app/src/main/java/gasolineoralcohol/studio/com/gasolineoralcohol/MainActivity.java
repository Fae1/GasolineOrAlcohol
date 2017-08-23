package gasolineoralcohol.studio.com.gasolineoralcohol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText priceAlcohol;
    private EditText priceGasoline;
    private Button buttonVerify;
    private TextView result;

    private TextView conscientizationMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Locate screen components
        priceAlcohol = (EditText) findViewById(R.id.priceAlcoholId);
        priceGasoline = (EditText) findViewById(R.id.priceGasolineId);
        buttonVerify = (Button) findViewById(R.id.buttonVerifuId);
        result = (TextView) findViewById(R.id.resultLabelId);

        conscientizationMessage = (TextView) findViewById(R.id.conscientizationMessageID);


        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recovering values received
                Double textPriceAlcohol = Double.parseDouble(priceAlcohol.getText().toString());
                Double textPriceGasoline = Double.parseDouble(priceGasoline.getText().toString());


                if(textPriceAlcohol/textPriceGasoline >= 0.7){
                    result.setText("Vá de Gasolina!");
                }else {
                    result.setText("Vá de Álcool!");
                }
                conscientizationMessage.setText(String.format("Considerando o valor da gasolina, seria possível andar por %.2f " +
                        "Kms. Considerando o consumo do BMW i3 22, carro de emissão zero, e preço do Kwh em São Paulo - SP.", 160*((textPriceGasoline/0.238)/22)));
            }
        });

    }
}
