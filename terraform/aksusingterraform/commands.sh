kubectl create deployment app1 --image=kharatramesh/vadapavimages:vadapav
kubectl expose deployment/app1 --name=app1 --type=LoadBalancer --port=80
kubectl get service

kubectl get nodes --kubeconfig kubeconfig
cp kubeconfig ~/.kube/config
