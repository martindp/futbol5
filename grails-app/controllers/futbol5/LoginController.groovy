package futbol5

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.rest.RestfulController

import grails.plugins.rest.client.RestBuilder

import grails.converters.JSON
import grails.web.JSONBuilder
import groovy.util.slurpersupport.GPathResult
import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject
import org.codehaus.groovy.grails.web.servlet.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType


//import groovyx.net.http.HTTPBuilder
//import groovyx.net.http.ContentType
//import groovyx.net.http.Method
//import groovyx.net.http.RESTClient




import grails.plugin.springsecurity.annotation.Secured

@Transactional
class LoginController extends RestfulController{

static responseFormats = ['json', 'xml']
static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

@Secured(["permitAll"])
    def login()
    {
    def rest = new RestBuilder()
    def resp = rest.get("https://graph.facebook.com/me?access_token=CAACEdEose0cBAGE6gLSg25k1xWTNIHZAZCbC7Obd4oU6gmCZBnUwBizk1BgsAZB9y3ZBY7nsPe67PDvvuJdgjojwL3IkgEPELRvZA7csjV2sEoZCNQsTKRa1ZBZALjC48CMBZAZAvlqZCuo6ZA7OW6AbdumE4NMGbAyo4di6ud7oaXtFVdRILigVoVu4bOz2rEsZBMgVux2q0XxdvnLZAa2KXacf5T6Vz7wyjRC0xlDcfxW1KiyuwZDZD") {
                    accept JSON
                }

    def nombre = resp.json.first_name
    def apellido = resp.json.last_name
    def email = resp.json.email
    def uuid = UUID.randomUUID().toString()

    def authCode = new AuthorizationCode()
    authCode.code = uuid

    def client = new Client(
                       clientId: email,
                       authorizedGrantTypes: [authCode, 'refresh_token', 'implicit', 'password', 'client_credentials'],
                       authorities: ['ROLE_CLIENT'],
                       scopes: ['read', 'write'],
                       redirectUris: ['http://myredirect.com']
               )
    client.save(flush: true)



    respond client
    }


}
