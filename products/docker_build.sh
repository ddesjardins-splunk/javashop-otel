# requires dockerhub login
sudo docker build . -t javashop.products
sudo docker tag javashop.products shabushabu/javashop.products
sudo docker push shabushabu/javashop.products
