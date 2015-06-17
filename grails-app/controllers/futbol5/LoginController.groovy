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

    def errorAuth=[error: 'error', message: 'No esta autorizado para acceder a este recurso']
    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def login()
    {
        def token = params.access_token
        if(token){

        def rest = new RestBuilder()
        def resp = rest.get("https://graph.facebook.com/me?access_token=" + token) {
            accept JSON
        }

        def nombre = resp.json.first_name
        def apellido = resp.json.last_name
        def email = resp.json.email
        def uuid = UUID.randomUUID().toString()

        if(Usuario.findByEmail(email))
                    respond Usuario.findByEmail(email)

        def user = new Usuario(nombre: nombre, apellido: apellido, email: email, access_token: uuid, roles: ['USER'])
        user.save()

        respond user

        }
        else
            respond errorAuth
    }


}
