#test:
#	ansible localhost -m monitord -a "url=localhost user=zak"
install-infra:
	ansible-playbook site.yml
install-web:
	cd web ; npm install ; npm start
create-docker-web:
	./scripts/run-monitord-ui.sh
create-docker-img:
	./scripts/make-ui.sh
push-docker-img:
	./scripts/push-monitord-ui.sh
