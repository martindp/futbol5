package futbol5

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.rest.RestfulController


import groovyx.net.http.HTTPBuilder
import groovyx.net.http.ContentType
import groovyx.net.http.Method
import groovyx.net.http.RESTClient


import grails.plugin.springsecurity.annotation.Secured

@Transactional
class LoginController extends RestfulController{

static responseFormats = ['json', 'xml']
static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


        }
}
