
# Fleet Management

Fleet Management é um sistema simples de gerenciamento de frotas de veículos, desenvolvido para uso em desktop com Java 8 e Swing, utilizando banco de dados MySQL para armazenamento de dados.

## Funcionalidades

- **Cadastro de Veículos**: Adicione e edite dados de veículos, incluindo marca, modelo, ano, placa e outros detalhes.
- **Gerenciamento de Motoristas**: Registre motoristas associados aos veículos da frota.
- **Controle de Manutenções**: Acompanhe o histórico de manutenções e reparos de cada veículo.
- **Histórico de Uso**: Registre as viagens e o uso dos veículos, incluindo quilometragem e data de utilização.

## Tecnologias Utilizadas

- **Java 8**: Para a lógica da aplicação e interface gráfica.
- **Swing**: Framework gráfico para construção de interfaces em desktop.
- **MySQL**: Banco de dados para armazenamento de informações sobre veículos, motoristas e manutenções.

## Pré-requisitos

- **Java 8** instalado na máquina.
- **MySQL** configurado e em execução.

## Instalação

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/SEU_USUARIO/Fleet-Management.git
   cd Fleet-Management
   ```

2. **Configure o Banco de Dados**:

   - Crie um banco de dados MySQL para a aplicação:
   
     ```sql
     CREATE DATABASE fleet_management;
     ```

   - Execute o script SQL incluído no projeto (se disponível) para criar as tabelas necessárias.

3. **Configure a Conexão com o Banco**:

   - No arquivo `config.properties` (ou similar, dependendo do projeto), configure os detalhes de conexão com o banco de dados:

     ```properties
     db.url=jdbc:mysql://localhost:3306/fleet_management
     db.username=SEU_USUARIO
     db.password=SUA_SENHA
     ```

4. **Compile e Execute**:

   - Compile o projeto e execute o arquivo principal. 

   ```bash
   javac -d bin src/*.java
   java -cp bin Main
   ```

## Contribuição

Contribuições são bem-vindas! Para contribuir com o projeto:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`).
4. Envie para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## Licença

Este projeto é distribuído sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.
