package futbol5

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.rest.RestfulController

@Transactional
class ErrorController extends RestfulController{

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def errorAuth=[error: '401', message: 'No esta autorizado para acceder a este recurso']
    def errorNotFound=[error: '404', message: 'Recurso no disponible']
    def errorServer=[error: '500', message: 'Error de servidor']
    def errorBad=[error: '400', message: 'Llamada invalida']

    def beforeInterceptor = {
        response.setHeader('Access-Control-Allow-Origin', '*')
        response.setHeader('Access-Control-Allow-Methods', 'POST, PUT, GET, OPTIONS, PATCH')
        response.setHeader('Access-Control-Allow-Headers', 'X-Additional-Headers-Example')
        response.setHeader('Access-Control-Allow-Credentials', 'true')
        response.setHeader('Access-Control-Max-Age', '1728000')
    }

    def errorAuth() {
        respond errorAuth
    }

    def errorNotFound() {
        respond errorNotFound
    }

    def errorServer() {
        respond errorServer
    }

    def badRequest() {
        respond errorBad
    }
}
