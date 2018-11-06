const int EchoPin = 17;
const int TriggerPin = 16;
void setup() {
 Serial.begin(115200);
 pinMode(TriggerPin, OUTPUT);
 pinMode(EchoPin, INPUT);
}
void loop() {

  char command = (char) Serial.read();

  if ( command == 'H'){
    Serial.println("HOLA MUNDO");
    }

  if (command == 'D'){
    
 Serial.print("DISTANCIA: ");
 Serial.print(distancia(TriggerPin, EchoPin));
 Serial.println("HACKICO");
 delay(1000); 

    }
}

int distancia(int TriggerPin, int EchoPin) {
 long duracion, distanciaCm;
 digitalWrite(TriggerPin, LOW); //nos aseguramos señal baja al principio
 delayMicroseconds(4);
 digitalWrite(TriggerPin, HIGH); //generamos pulso de 10us
 delayMicroseconds(10);
 digitalWrite(TriggerPin, LOW);
 duracion = pulseIn(EchoPin, HIGH); //medimos el tiempo del pulso
 distanciaCm = duracion * 10 / 292 / 2; //convertimos a distancia
 return distanciaCm;
}
