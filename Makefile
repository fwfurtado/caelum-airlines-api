DOCKER_COMPOSE_PATH=docker-compose
DOCKER_COMPOSE_FILE=$(DOCKER_COMPOSE_PATH)/base.yml
DOCKER_COMPOSE_UP= up -d
DOCKER_COMPOSE_DOWN= down -v
DOCKER_COMPOSE_EXEC= exec
DOCKER_COMPOSE_PS= ps
DOCKER_COMPOSE_LOGS= logs
DOCKER_COMPOSE_BUILD= build
env ?= local

application/raise: docker/build
	@ make _docker-compose command=$(DOCKER_COMPOSE_UP)

application/down:
	@ make _docker-compose command=$(DOCKER_COMPOSE_DOWN)

application/stats:
	@ make _docker-compose command=$(DOCKER_COMPOSE_PS)

logs:
	@ make _docker-compose command="$(DOCKER_COMPOSE_LOGS) $(service)"

ssh:
	@ make _docker-compose command="$(DOCKER_COMPOSE_EXEC) $(service) bash"

db/start:
	@ make _docker-compose command="$(DOCKER_COMPOSE_UP) database"

docker/build:
	@ make _docker-compose command=$(DOCKER_COMPOSE_BUILD)

_docker-compose:
ifndef command
	$(error "the 'command' arg must be specified.")
endif
	$(info command $(command))
	@ docker-compose -f $(DOCKER_COMPOSE_FILE) -f $(DOCKER_COMPOSE_PATH)/$(env).yml $(command)

