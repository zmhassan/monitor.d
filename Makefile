# test:
#	ansible localhost -m monitord -a "url=localhost user=zak"
install-infra:
	ansible-playbook site.yml
install-web:
	cd web ; npm install ; npm start
create-docker-web:
	./bin/run-monitord-ui.sh
create-docker-img:
	./bin/make-ui.sh
push-docker-img:
	./bin/push-monitord-ui.sh
build:
	mvn clean install