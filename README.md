# Tested on Ubuntu 18.04 ( k8s 18.8 )

( Assumes SignalFx Smart Agent is installed as Daemonset according to: 

https://docs.signalfx.com/en/latest/integrations/kubernetes/k8s-quick-install.html

# You will also need:
Git, Java 8 or above, Maven, Docker.

# Steps

#Git clone
https://github.com/ddesjardins-splunk/javashop-otel
	
cd ot-k8s-java

# If you just want to run the example

#Add to k8s

kubectl apply -f shop/shop.yaml

kubectl apply -f products/products.yaml

kubectl apply -f stock/stock.yaml

#Find nodePort for shop service

kubectl get svc

#take note of the port for the shop service use that as SHOP_SERVICE_PORT below

#Open in browser - t http://<YOUR_NODE_IP>:<SHOP_SERVICE_PORT>/?name=MyName&color=Blue

# If you want to build it . . .Repeat steps for products and stock.

cd shop

Mvn clean install

docker build -t YourNameHere/shabu-shop:1.0 .

#login to docker

docker push YourNameHere/shabu-shop:1.0

vi shop/shop.yaml # Add your image name above YourNameHere/shabu-shop:1.0 to the shop.yaml file.

kubectl apply -f shop/shop.yaml

