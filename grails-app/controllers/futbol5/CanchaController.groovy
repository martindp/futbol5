package futbol5

import grails.rest.RestfulController

class CanchaController extends RestfulController {

    def index() {
     redirect action: 'hello'
    }

    def hello() {
            render "hello"
        }
}
