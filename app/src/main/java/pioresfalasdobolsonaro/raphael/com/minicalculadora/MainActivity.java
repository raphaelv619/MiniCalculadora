package pioresfalasdobolsonaro.raphael.com.minicalculadora;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText textoResposta;

    private Button botao0;
    private Button botao1;
    private Button botao2;
    private Button botao3;
    private Button botao4;
    private Button botao5;
    private Button botao6;
    private Button botao7;
    private Button botao8;
    private Button botao9;

    private Button botaoMais;
    private Button botaoMenos;
    private Button botaoDivisao;
    private Button botaoMultiplicar;

    private Button botaoVirgula;
    private Button botaoIgual;
    private Button botaoClear;

    private int flag = 0;

    private double primeiroNumero = 0;
    private double segundoNumero = 0;

    boolean maisClicado = false;
    boolean menosClicado = false;
    boolean multiplicarClicado = false;
    boolean divisaoClicado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResposta = (EditText) findViewById(R.id.mostrarResultadoId);

        botao0 = (Button) findViewById(R.id.botao0Id);
        botao1 = (Button) findViewById(R.id.botao1Id);
        botao2 = (Button) findViewById(R.id.botao2Id);
        botao3 = (Button) findViewById(R.id.botao3Id);
        botao4 = (Button) findViewById(R.id.botao4Id);
        botao5 = (Button) findViewById(R.id.botao5Id);
        botao6 = (Button) findViewById(R.id.botao6Id);
        botao7 = (Button) findViewById(R.id.botao7Id);
        botao8 = (Button) findViewById(R.id.botao8Id);
        botao9 = (Button) findViewById(R.id.botao9Id);

        botaoMais = (Button) findViewById(R.id.botaoMaisId);
        botaoMenos = (Button) findViewById(R.id.botaoMenosId);
        botaoMultiplicar = (Button) findViewById(R.id.botaoMultiplicarId);
        botaoDivisao = (Button) findViewById(R.id.botaoDivisaoId);

        botaoVirgula = (Button) findViewById(R.id.botaoVirgulaId);
        botaoIgual = (Button) findViewById(R.id.botaoIgualId);
        botaoClear = (Button) findViewById(R.id.botaoClearId);

        textoResposta.setEnabled(false);
        textoResposta.setClickable(false);


        botao0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarPrimeiroDigito();
                flag ++;
                armazenarNumeros("0");
            }
        });

        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarPrimeiroDigito();
                flag ++;
                armazenarNumeros("1");
            }
        });

        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarPrimeiroDigito();
                flag ++;
                armazenarNumeros("2");
            }
        });

        botao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarPrimeiroDigito();
                flag ++;
                armazenarNumeros("3");
            }
        });

        botao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarPrimeiroDigito();
                flag ++;
                armazenarNumeros("4");
            }
        });

        botao5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarPrimeiroDigito();
                flag ++;
                armazenarNumeros("5");
            }
        });

        botao6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarPrimeiroDigito();
                flag ++;
                armazenarNumeros("6");
            }
        });

        botao7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarPrimeiroDigito();
                flag ++;
                armazenarNumeros("7");
            }
        });

        botao8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarPrimeiroDigito();
                flag ++;
                armazenarNumeros("8");
            }
        });

        botao9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testarPrimeiroDigito();
                flag ++;
                armazenarNumeros("9");
            }
        });

        botaoMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (maisClicado) {
                    quebrarString();
                    textoResposta.setText(null);
                    soma(primeiroNumero, segundoNumero);
                }
                maisClicado = true;
                armazenarNumeros("+");
            }
        });

        botaoMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menosClicado) {
                    quebrarString();
                    textoResposta.setText(null);
                    subtrair(primeiroNumero, segundoNumero);
                }
                menosClicado = true;
                armazenarNumeros("-");
            }
        });

        botaoMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (multiplicarClicado) {
                    quebrarString();
                    textoResposta.setText(null);
                    multiplicar(primeiroNumero, segundoNumero);
                }
                multiplicarClicado = true;
                armazenarNumeros("*");
            }
        });

        botaoDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (divisaoClicado) {
                    quebrarString();
                    textoResposta.setText(null);
                    dividir(primeiroNumero, segundoNumero);
                }
                divisaoClicado = true;
                armazenarNumeros("/");
            }
        });

        botaoVirgula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                armazenarNumeros(".");
            }
        });

        botaoIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quebrarString();
                textoResposta.setText(null);
                if (maisClicado){
                    soma(primeiroNumero, segundoNumero);
                    maisClicado = false;
                } else if (menosClicado) {
                    subtrair(primeiroNumero, segundoNumero);
                    menosClicado = false;
                } else if (multiplicarClicado) {
                    multiplicar(primeiroNumero, segundoNumero);
                    multiplicarClicado = false;
                } else if (divisaoClicado) {
                    dividir(primeiroNumero, segundoNumero);
                    divisaoClicado = false;
                }
            }
        });

        botaoClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });



    } private void armazenarNumeros (String numero) {
        String armazenar;
        armazenar = textoResposta.getText() + numero;
        textoResposta.setText(armazenar);

    }

      private void testarPrimeiroDigito () {
          if ( flag == 0 ) {
              textoResposta.setText(null);
          }
      }

      private void soma (double numero1, double numero2) {
          double resultado = 0;
          resultado = numero1 + numero2;
          textoResposta.setText(null);
          String resultadoSoma = Double.toString(resultado);
          textoResposta.setText(resultadoSoma);
      }

      private void subtrair (double numero1, double numero2) {
          double resultado = 0;
          resultado = numero1 - numero2;
          textoResposta.setText(null);
          String resultadoSubtracao = Double.toString(resultado);
          textoResposta.setText(resultadoSubtracao);
      }

    private void multiplicar (double numero1, double numero2) {
        double resultado = 0;
        resultado = numero1 * numero2;
        textoResposta.setText(null);
        String resultadoMultiplicacao = Double.toString(resultado);
        textoResposta.setText(resultadoMultiplicacao);
    }

    private void dividir (double numero1, double numero2) {
        double resultado = 0;
        resultado = numero1 / numero2;
        if (numero2 != 0) {
            textoResposta.setText(null);
            String resultadoDivisao = Double.toString(resultado);
            textoResposta.setText(resultadoDivisao);
        } else {
            clear();
            Toast.makeText(getApplicationContext(), "Não é possível dividir por zero.", Toast.LENGTH_LONG).show();
        }
    }

     private void quebrarString () {
         String textoParaSeparar = textoResposta.getText().toString();
         String[] separadora = new String[0];
         if(maisClicado){
             separadora = textoParaSeparar.split("\\+");
         } else if (menosClicado) {
             separadora = textoParaSeparar.split("-");
         } else if (multiplicarClicado) {
             separadora = textoParaSeparar.split("\\*");
         } else if (divisaoClicado) {
             separadora = textoParaSeparar.split("/");
         }
         String firstNum = separadora[0];
         String secondNum = separadora[1];
         primeiroNumero = Double.parseDouble(firstNum);
         segundoNumero = Double.parseDouble(secondNum);
     }

    private void clear () {

        textoResposta.setText("0");
        flag = 0;
        primeiroNumero = 0;
        segundoNumero = 0;
        maisClicado = false;
        menosClicado = false;
        multiplicarClicado = false;
        divisaoClicado = false;

    }


}
