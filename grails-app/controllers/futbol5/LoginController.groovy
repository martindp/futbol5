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

    @Secured(["permitAll"])
    def login()
    {

   // String callbackUrl = "ApplicationUrl/controller/action"
    //String facebookAuthorizeUrl = "https://graph.facebook.com/oauth/authorize?client_id=FacebookApiKey&redirect_uri=callbackUrl&scope=facebookPermissions"  //
    //redirect(url: facebookAuthorizeUrl)


//def resp = rest.get("graph.facebook.com/me")
 //resp.json



   //def client = new RESTClient("https://graph.facebook.com/v2.3/me?access_token=")
   //String token="CAACEdEoD"
   //def resp = client.get(path: token)


    //def http = new RESTClient('https://graph.facebook.com/v2.3/me?access_token=CAACEdEose0cBABz0S6pxZB6ZA4q2PVNEvjXNA85pshHawAxLBzX3wpMaDEGYqjkdgZBZCqIdnUl35CZAaVfth53ZCSt1OqN2byjrnO7yHcQrDWm18nZBSvIifOyTz4PEorworVEnEx7mI4Y5ZChIqu2RJ3ZB5eQ5eTLL9nx3kSMZBUrNu3JLXXohW8LqDeKJTgGgSRSRL8g15o57Fc8yMBf7yPqLb27EkpvZCVPBZCeyLfrh7QZDZD')

    //http.setHeaders(Accept: "application/json", ("User-Agent"): "Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4")
    //def resp = http.get(path: "/")

   //def http = new HTTPBuilder()
   //http.setProxy('localhost',8888,'http')
   //http.request( 'https://graph.facebook.com', Method.GET, ContentType.JSON ) { req ->
   //uri.path = '/v2.3/me'
   //uri.query = [  access_token: 'CAACEdEose0cBADAT4XumlYSGoEFFwmZADwvCp5LhhbSQZASZAtBtPHlZCN0COuQFoT27AtHJk6Gk3M95d7xZBjADOkepH5wgaXm8paYBo2wpGh9tXFLd7HeCtW9FprBrgf4gbcdcFw72WqFU7c1GZBs8X6wosHZBxMGvu8rKg3ZA8rFzp7sLDNWS6VA0gRQl6vSx3urukQmjzonc55xMjBiKO6APmGJIsApscYTxHrynogZDZD' ]
   //headers.'User-Agent' = 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36'
   //headers.Accept = 'application/json'
   //headers.'Accept-Encoding' = 'gzip, deflate, sdch'

   //response.success = { resp, reader ->
   //assert resp.statusLine.statusCode == 200
   //println "Got response: ${resp.statusLine}"
   //println "Content-Type: ${resp.headers.'Content-Type'}"
   //respond reader.text
   //}


   //response.'404' = {
   //println 'Not found'
//   }
  // }





        }
}
