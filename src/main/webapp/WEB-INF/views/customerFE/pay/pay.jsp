<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2>Payment Information</h2>
            <form>
                <div class="form-group">
                    <label for="receiverName">Receiver Name:</label>
                    <input type="text" class="form-control" id="receiverName" name="receiverName">
                </div>
                <div class="form-group">
                    <label for="totalMoney">Total Money:</label>
                    <input type="text" class="form-control" id="totalMoney" name="totalMoney">
                </div>
                <div class="form-group">
                    <label for="customerPhone">Customer Phone:</label>
                    <input type="text" class="form-control" id="customerPhone" name="customerPhone">
                </div>
                <div class="form-group">
                    <label for="addressDelivery">Address Delivery:</label>
                    <textarea class="form-control" id="addressDelivery" name="addressDelivery"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="col-md-6">
            <h2>Your shopping cart</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Sản phẩm 1</td>
                    <td>$10</td>
                    <td>2</td>
                    <td>$20</td>
                </tr>
                <tr>
                    <td>Sản phẩm 2</td>
                    <td>$20</td>
                    <td>1</td>
                    <td>$20</td>
                </tr>
                <tr>
                    <td>Sản phẩm 3</td>
                    <td>$30</td>
                    <td>3</td>
                    <td>$90</td>
                </tr>
                </tbody>
            </table>
            <h4>Total: $130</h4>
        </div>
    </div>
</div>