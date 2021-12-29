# requires dockerhub login
sudo docker build . -t javashop.shop
sudo docker tag javashop.shop shabushabu/javashop.shop
sudo docker push shabushabu/javashop.shop
