# amq-rhsso-integration

## Prepare installation

```
oc extract secret/router-certs-default -n openshift-ingress --confirm
keytool -import -noprompt -file tls.crt -alias .apps-crc.testing -keystore helm/plain-sso-amq-example/truststore/truststore.jks -storepass password
```

## Install operators chart
```
helm repo add redhat-cop https://redhat-cop.github.io/helm-charts
helm --debug upgrade --install -f ./helm/operators-values.yaml example-operators redhat-cop/operators-installer --namespace=example --create-namespace
```
### Verify operator installed
- RHSSO operator '7.6.1' installed in 'example' namespace
- RHAMQ operator '7.10.2' installed with cluster scope

## Install plain-sso-amq-example chart

```
helm --debug upgrade --install amq-rhsso-plain-integration ./helm/plain-sso-amq-example/ --namespace example
```