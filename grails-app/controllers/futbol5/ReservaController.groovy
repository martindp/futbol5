package futbol5

import grails.transaction.*
import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*
import grails.rest.RestfulController

@Transactional(readOnly = true)
class ReservaController extends RestfulController{

static responseFormats = ['json', 'xml']

ReservaController(){
	super(Reserva)
}
}
