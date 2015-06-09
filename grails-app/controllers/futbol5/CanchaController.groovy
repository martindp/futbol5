package futbol5

import grails.transaction.*
import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*
import grails.rest.RestfulController

@Transactional(readOnly = true)
class CanchaController extends RestfulController{

static responseFormats = ['json', 'xml']

CanchaController(){
	super(Cancha)
}
}
