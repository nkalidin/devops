curl -L https://istio.io/downloadIstio | sh -
cd istio-1.18.0
export PATH=$PWD/bin:$PATH
istioctl install --set profile=demo -y
kubectl label namespace default istio-injection=enabled
kubectl apply -f samples/bookinfo/platform/kube/bookinfo.yaml
kubectl get services
kubectl get pods
watch kubectl get pods
kubectl exec "$(kubectl get pod -l app=ratings -o jsonpath='{.items[0].metadata.name}')" -c ratings -- curl -sS productpage:9080/productpage | grep -o "<title>.*</title>"
vi samples/bookinfo/networking/bookinfo-gateway.yaml
kubectl create -f samples/bookinfo/networking/bookinfo-gateway.yaml
istioctl analyze
 kubectl expose deployment/productpage-v1 --name=plb1 --type=LoadBalancer --port=9080
http://20.237.77.74:9080/productpage
20.237.74.7

   44  kubectl apply -f samples/addons
   45  kubectl rollout status deployment/kiali -n istio-system
   46  kubectl get ns
   48  kubectl get deployments -n istio-system
   49  kubectl get pods -n istio-system
   50  kubectl get service -n istio-system
   53  kubectl expose deployment/kiali --name=kiali1 --type=LoadBalancer --port=20001 -n istio-system
   54  kubectl get service -n istio-system


http://20.81.122.212:20001/kiali
