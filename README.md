# Employee Manager

An employee mangement, HR-focused, application.

## Archived

An OAuth2 Resource Server that generates a `DefaultOAuth2AuthenticatedPrincipal` from the `/userinfo` endpoint.

Exchange an Auth Code for an Acess Token

```
http -f https://dev-95805580.okta.com/oauth2/default/v1/token \
    grant_type=authorization_code \
    code=<AUTH_CODE> \
    client_id=0oa8mf5aulCthNW5S5d7 \
    client_secret=<CLIENT_SECRET> \     
    redirect_uri=https://oidcdebugger.com/debug
```

Retrieve User Info

```
http -f https://dev-95805580.okta.com/oauth2/default/v1/userinfo \
    'Authorization: Bearer <ACCESS_TOKEN>'
```