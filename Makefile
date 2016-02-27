test:
	ansible localhost -m monitord -a "url=localhost user=zak"
installinfra:
	ansible-playbook site.yml
installweb:
	cd web/webapp & npm install
testweb:
	cd web/webapp & echo "Go to url: http://localhost:8000/web/webapp/app" & http-server -a localhost -p 8000 -c-1 
