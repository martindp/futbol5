package futbol5

import grails.transaction.*
import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*
import grails.rest.RestfulController

@Transactional(readOnly = true)
class UsuarioController extends RestfulController{

static responseFormats = ['json', 'xml']

UsuarioController(){
	super(Usuario)
}
}
