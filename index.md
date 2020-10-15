<!doctype html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css">
  <title>White box carttonization (carttonize yourself)</title>
</head>

<body>
  <div align='center'>
    <h1>White box cartoonization</h1>
  </div>

  <div class="card-deck m-4 py-2 px-4">
    <div class="card shadow col-md-6">
      <div class="card-body px-0 px-sm-2">
        <div class="">
          <label class="btn btn-primary btn-xs px-2">
            Upload your Image <input type="file" id="file" name="file" accept="image/*" hidden>
          </label>
        </div>
        <img id="input" class="d-block img-fluid mx-auto"></img>
      </div>
    </div>
    <div class="card shadow col-md-6">
      <div class="card-body px-0 px-sm-2">
        <div class="d-flex justify-content-between align-items-baseline">
          <h5 class="card-title">Cartoonized Image</h5>
          <a id="download" class="btn btn-xs btn-primary px-2" download="cartoon.jpg" href="">Download</a>
        </div>
        <canvas id="output" class="d-none img-fluid mx-auto"></canvas>
        <div id="status" class="placeholder">
          Please wait..
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs/dist/tf.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs-backend-wasm/dist/tf-backend-wasm.js"></script>
  <script async src="model.js"></script>
</body>
</html>
