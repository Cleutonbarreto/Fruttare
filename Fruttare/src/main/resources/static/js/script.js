//        function iniciarNovoCadastro() {
//              document.getElementById('myForm').reset();
//              document.querySelector('.mensagem-sucesso p').innerText = '';
//              document.getElementById('name').focus();
//        }

        $(document).ready(function() {
        $('#cpf').mask('000.000.000-00', {reverse: true});

        $('form').submit(function() {
        var cpfValue = $('#cpf').cleanVal(); // Obtém o valor sem a máscara
        $('#cpf').val(cpfValue); // Atualiza o campo com o valor sem a máscara
        });

        $('#cep').mask('00000-000');

        $('#phone').mask('(00) 00000-0000');

        $('#uf').mask('00')
    });

