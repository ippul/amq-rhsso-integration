# amq-rhsso-integration

## Prepare installation
```
oc extract secret/router-certs-default -n openshift-ingress --keys=tls.crt --to=/tmp --confirm
keytool -import -noprompt -file /tmp/tls.crt -alias .apps-crc.testing -keystore helm/plain-sso-amq-example/truststore/truststore.jks -storepass password
```

## Install operators chart
```
helm repo add redhat-cop https://redhat-cop.github.io/helm-charts
helm --debug upgrade --install -f ./helm/operators-values.yaml example-operators redhat-cop/operators-installer --namespace=example --create-namespace
```

## Install plain-sso-amq-example chart
```
helm --debug upgrade --install amq-rhsso-plain-integration ./helm/plain-sso-amq-example/ --namespace example
```

## Install amq-clients-example chart
```
helm --debug upgrade --install amq-clients-example ./helm/amq-clients-example/ --namespace example
```