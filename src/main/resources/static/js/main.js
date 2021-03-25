var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
        calculation: {
            id: 0,
            first_operand: 2,
            second_operand: 3,
            result: 0,
            operation: '*'
        },
        calculations: []
    },
    created() {
        this.Get();
    },
    methods: {
        async Get() {
            const response = await fetch('http://localhost:8080/api/calculation', {
                method: 'GET',
                mode: 'cors',
                cache: 'no-cache',
                credentials: 'same-origin',
                headers: {
                    'Content-Type': 'application/json'
                },
            });
            if (response.status != 200) {
                alert('Что-то пошло не так(');
            }
            else {
                const result = await response.json();
                this.calculations = result;
            }
        },
        async Post() {
            const operation = document.getElementById("operations").value;
            const response = await fetch('http://localhost:8080/api/calculation', {
                method: 'POST',
                mode: 'cors',
                cache: 'no-cache',
                credentials: 'same-origin',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    id: 0,
                    first_operand: this.calculation.first_operand,
                    second_operand: this.calculation.second_operand,
                    result: 0,
                    operation: operation,
                    operation_string: ''
                })
            });
            if (response.status != 200) {
                alert('Что-то пошло не так(');
            }
            else {
                const result = await response.json();
                this.calculation = result;
                this.calculations.push(result);
            }
        }

    }
});