DOCKER_COMPOSE_PATH=docker-compose
DOCKER_COMPOSE_FILE=$(DOCKER_COMPOSE_PATH)/base.yml
DOCKER_COMPOSE_UP='up -d'
DOCKER_COMPOSE_DOWN= 'down -v'
env ?= local

db/start:
	@ make _docker-compose command=$(DOCKER_COMPOSE_UP)

db/stop:
	@ make _docker-compose command=$(DOCKER_COMPOSE_DOWN)

db/shell:
	@ make _docker-compose command='exec database psql -U postgres'

_docker-compose:
ifndef command
	$(error "the 'command' arg must be specified.")
endif
	@ docker-compose -f $(DOCKER_COMPOSE_FILE) -f $(DOCKER_COMPOSE_PATH)/$(env).yml $(command)
