## Run echo server in container

Run this comands:

`$ mvn clean package`

in `simplejava-echoserver/` directory:

`$ docker build -t simplejava .`

`$ docker run -dp 5000:5000 simplejava`