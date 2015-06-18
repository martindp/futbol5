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


@Transactional
class LoginController extends RestfulController{

    def errorAuth=[error: '400', message: 'No esta autorizado para acceder a este recurso']
    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def beforeInterceptor = {
        response.setHeader('Access-Control-Allow-Origin', '*')
        response.setHeader('Access-Control-Allow-Methods', 'POST, PUT, GET, OPTIONS, PATCH')
        response.setHeader('Access-Control-Allow-Headers', 'X-Additional-Headers-Example')
        response.setHeader('Access-Control-Allow-Credentials', 'true')
        response.setHeader('Access-Control-Max-Age', '1728000')
    }

    def login()
    {
        def email = params.email
        def password = params.password

    	if(email && password){
        //def token = params.access_token
        //if(token){

        //def rest = new RestBuilder()
        //def resp = rest.get("https://graph.facebook.com/me?access_token=" + token) {
        //    accept JSON
        //}

        //def nombre = resp.json.first_name
        //def apellido = resp.json.last_name
        //def email = resp.json.email

        def uuid = UUID.randomUUID().toString()

        if(Usuario.findByEmail(email))
                    respond Usuario.findByEmail(email)

        def user = new Usuario(email: email, password: password, access_token: uuid, roles: ['USER'])
        user.save(flush: true)

        respond user

        }
        else
            respond errorAuth
    }


}
