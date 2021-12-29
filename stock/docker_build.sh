# requires dockerhub login
sudo docker build . -t javashop.stock
sudo docker tag javashop.stock shabushabu/javashop.stock
sudo docker push shabushabu/javashop.stock
