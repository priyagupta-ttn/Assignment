<script>
    (function($) {
        const prices = {
            "espresso": 3,
            "latte": 4,
            "cappuccino": 4.5,
            "americano": 3.5,
            "mocha": 5,
            "macchiato": 4.5,
            "flat_white": 4,
            "black_coffee": 2.5
        };

        $('#coffeeForm').on('input', function() {
            const coffeeType = $('#coffee').val();
            const quantity = $('#quantity').val();
            const total = prices[coffeeType] * quantity;
            $('#total').text(`Total: $${total.toFixed(2)}`);
        });

        $('#coffeeForm').on('submit', function(event) {
            event.preventDefault();
            const coffeeType = $('#coffee').val();
            const quantity = $('#quantity').val();
            const total = prices[coffeeType] * quantity;

            $.ajax({
                url: '/bin/submitcoffeeorder',
                method: 'POST',
                data: JSON.stringify({
                    coffeeType: coffeeType,
                    quantity: quantity,
                    total: total
                }),
                contentType: 'application/json',
                success: function(response) {
                    window.location.href = '/content/ttn/en/order-status.html';
                },
                error: function(xhr, status, error) {
                    console.error("An error occurred:", status, error);
                }
            });
        });
    })(jQuery);
</script>