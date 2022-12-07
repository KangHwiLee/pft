<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <script src="resources/core_ui/js/main.js"></script>
     <script src="resources/core_ui/vendors/chart.js/js/chart.min.js"></script>
    <script src="resources/core_ui/vendors/@coreui/chartjs/js/coreui-chartjs.js"></script>

    
            <div class="col-sm-6 col-lg-4">
              <div class="card mb-4 text-white bg-primary">
                <div class="card-body pb-0 d-flex justify-content-between align-items-start">
                  <div>
                    <div class="fs-4 fw-semibold">26K <span class="fs-6 fw-normal">(-12.4%
                        <svg class="icon">
                          <use xlink:href="resources/core_ui/vendors/@coreui/icons/svg/free.svg#cil-arrow-bottom"></use>
                        </svg>)</span></div>
                    <div>Users</div>
                  </div>
                  <div class="dropdown">
                    <button class="btn btn-transparent text-white p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <svg class="icon">
                        <use xlink:href="resources/core_ui/vendors/@coreui/icons/svg/free.svg#cil-options"></use>
                      </svg>
                    </button>
                    <div class="dropdown-menu dropdown-menu-end"><a class="dropdown-item" href="#">Action</a><a class="dropdown-item" href="#">Another action</a><a class="dropdown-item" href="#">Something else here</a></div>
                  </div>
                </div>
                <div class="c-chart-wrapper mt-3 mx-3" style="height:70px;">
                  <canvas class="chart" id="card-chart1" height="70"></canvas>
                </div>
                <script>
                var cardChart1 = new Chart(document.getElementById('card-chart1'), {
                	  type: 'line',
                	  data: {
                	    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                	    datasets: [{
                	      label: 'My First dataset',
                	      backgroundColor: 'transparent',
                	      borderColor: 'rgba(255,255,255,.55)',
                	      pointBackgroundColor: coreui.Utils.getStyle('--cui-primary'),
                	      data: [65, 59, 84, 84, 51, 55, 40]
                	    }]
                	  },
                	  options: {
                	    plugins: {
                	      legend: {
                	        display: false
                	      }
                	    },
                	    maintainAspectRatio: false,
                	    scales: {
                	      x: {
                	        grid: {
                	          display: false,
                	          drawBorder: false
                	        },
                	        ticks: {
                	          display: false
                	        }
                	      },
                	      y: {
                	        min: 30,
                	        max: 89,
                	        display: false,
                	        grid: {
                	          display: false
                	        },
                	        ticks: {
                	          display: false
                	        }
                	      }
                	    },
                	    elements: {
                	      line: {
                	        borderWidth: 1,
                	        tension: 0.4
                	      },
                	      point: {
                	        radius: 4,
                	        hitRadius: 10,
                	        hoverRadius: 4
                	      }
                	    }
                	  }
                	});
                </script>
              </div>
            </div>
            <!-- /.col-->
            <div class="col-sm-6 col-lg-4">
              <div class="card mb-4 text-white bg-info">
                <div class="card-body pb-0 d-flex justify-content-between align-items-start">
                  <div>
                    <div class="fs-4 fw-semibold">$6.200 <span class="fs-6 fw-normal">(40.9%
                        <svg class="icon">
                          <use xlink:href="resources/core_ui/vendors/@coreui/icons/svg/free.svg#cil-arrow-top"></use>
                        </svg>)</span></div>
                    <div>Income</div>
                  </div>
                  <div class="dropdown">
                    <button class="btn btn-transparent text-white p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <svg class="icon">
                        <use xlink:href="resources/core_ui/vendors/@coreui/icons/svg/free.svg#cil-options"></use>
                      </svg>
                    </button>
                    <div class="dropdown-menu dropdown-menu-end"><a class="dropdown-item" href="#">Action</a><a class="dropdown-item" href="#">Another action</a><a class="dropdown-item" href="#">Something else here</a></div>
                  </div>
                </div>
                <div class="c-chart-wrapper mt-3 mx-3" style="height:70px;">
                  <canvas class="chart" id="card-chart2" height="70"></canvas>
                </div>
                
                <script>
                var cardChart2 = new Chart(document.getElementById('card-chart2'), {
                	  type: 'line',
                	  data: {
                	    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                	    datasets: [{
                	      label: 'My First dataset',
                	      backgroundColor: 'transparent',
                	      borderColor: 'rgba(255,255,255,.55)',
                	      pointBackgroundColor: coreui.Utils.getStyle('--cui-info'),
                	      data: [1, 18, 9, 17, 34, 22, 11]
                	    }]
                	  },
                	  options: {
                	    plugins: {
                	      legend: {
                	        display: false
                	      }
                	    },
                	    maintainAspectRatio: false,
                	    scales: {
                	      x: {
                	        grid: {
                	          display: false,
                	          drawBorder: false
                	        },
                	        ticks: {
                	          display: false
                	        }
                	      },
                	      y: {
                	        min: -9,
                	        max: 39,
                	        display: false,
                	        grid: {
                	          display: false
                	        },
                	        ticks: {
                	          display: false
                	        }
                	      }
                	    },
                	    elements: {
                	      line: {
                	        borderWidth: 1
                	      },
                	      point: {
                	        radius: 4,
                	        hitRadius: 10,
                	        hoverRadius: 4
                	      }
                	    }
                	  }
                	});
                </script>
                
              </div>
            </div>
            <!-- /.col-->
            <div class="col-sm-6 col-lg-4">
              <div class="card mb-4 text-white bg-warning">
                <div class="card-body pb-0 d-flex justify-content-between align-items-start">
                  <div>
                    <div class="fs-4 fw-semibold">2.49% <span class="fs-6 fw-normal">(84.7%
                        <svg class="icon">
                          <use xlink:href="resources/core_ui/vendors/@coreui/icons/svg/free.svg#cil-arrow-top"></use>
                        </svg>)</span></div>
                    <div>Conversion Rate</div>
                  </div>
                  <div class="dropdown">
                    <button class="btn btn-transparent text-white p-0" type="button" data-coreui-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <svg class="icon">
                        <use xlink:href="resources/core_ui/vendors/@coreui/icons/svg/free.svg#cil-options"></use>
                      </svg>
                    </button>
                    <div class="dropdown-menu dropdown-menu-end"><a class="dropdown-item" href="#">Action</a><a class="dropdown-item" href="#">Another action</a><a class="dropdown-item" href="#">Something else here</a></div>
                  </div>
                </div>
                <div class="c-chart-wrapper mt-3" style="height:70px;">
                  <canvas class="chart" id="card-chart3" height="70"></canvas>
                </div>
                <script>
                var cardChart3 = new Chart(document.getElementById('card-chart3'), {
                	  type: 'line',
                	  data: {
                	    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                	    datasets: [{
                	      label: 'My First dataset',
                	      backgroundColor: 'rgba(255,255,255,.2)',
                	      borderColor: 'rgba(255,255,255,.55)',
                	      data: [78, 81, 80, 45, 34, 12, 40],
                	      fill: true
                	    }]
                	  },
                	  options: {
                	    plugins: {
                	      legend: {
                	        display: false
                	      }
                	    },
                	    maintainAspectRatio: false,
                	    scales: {
                	      x: {
                	        display: false
                	      },
                	      y: {
                	        display: false
                	      }
                	    },
                	    elements: {
                	      line: {
                	        borderWidth: 2,
                	        tension: 0.4
                	      },
                	      point: {
                	        radius: 0,
                	        hitRadius: 10,
                	        hoverRadius: 4
                	      }
                	    }
                	  }
                	});
                </script>
              </div>
            </div>
            <!-- /.col-->
          <!-- /.row-->
          <div class="card mb-4">
            <div class="card-body">
              <div class="d-flex justify-content-between">
                <div>
                  <h4 class="card-title mb-0">인사글</h4>
                  <div class="small text-medium-emphasis">Back-End Developer</div>
                </div>
                </div>
              </div>
              <div class="c-chart-wrapper" style="height:300px;margin-top:40px;">
               <p style="padding-left:14px">포트폴리오 겸 앞으로 제 기술스택을 모두 기록할 개인 블로그입니다.</p><br>
               <p style="padding-left:14px">아직 실력이 모자르고 부족한 부분이 많겠지만 이 블로그와 함께 같이 성장하고자 합니다.</p><br>
               <p style="padding-left:14px">감사합니다</p><br>
              </div>
            </div>
          <!-- /.card.mb-4-->
          <div class="row">
            <div class="col-mb-4">
              <div class="card mb-4">
                <div class="card-header">기술 스택(좋아하는 정도)</div>
                <div class="card-body">
                  <div class="row">
                    <!-- /.col-->
                    <div class="col-sm-12">
                      <div class="row">
                      </div>
                      <!-- /.row-->
                      <hr class="mt-0">
                      
                      <div class="progress-group">
                        <div class="progress-group-header">
                          <div>Java</div>
                          <div class="ms-auto fw-semibold">100%</div>
                        </div>
                        <div class="progress-group-bars">
                          <div class="progress progress-thin">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: 100%" aria-valuenow="43" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                      </div>
                      
                      <div class="progress-group mb-5">
                        <div class="progress-group-header">
                          <div>JavaScript</div>
                          <div class="ms-auto fw-semibold">95%</div>
                        </div>
                        <div class="progress-group-bars">
                          <div class="progress progress-thin">
                            <div class="progress-bar bg-warning" role="progressbar" style="width: 95%" aria-valuenow="43" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                      </div>
                      
                      <div class="progress-group">
                        <div class="progress-group-header">
                          <div>MySql</div>
                          <div class="ms-auto fw-semibold me-2">60%</div>
                        </div>
                        <div class="progress-group-bars">
                          <div class="progress progress-thin">
                            <div class="progress-bar bg-success" role="progressbar" style="width: 60%" aria-valuenow="56" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                      </div>
                      
                      <div class="progress-group">
                        <div class="progress-group-header">
                          <div>Linux(Ubuntu)</div>
                          <div class="ms-auto fw-semibold me-2">55%</div>
                        </div>
                        <div class="progress-group-bars">
                          <div class="progress progress-thin">
                            <div class="progress-bar bg-success" role="progressbar" style="width: 55%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                      </div>
                      
                      <div class="progress-group">
                        <div class="progress-group-header">
                          <div>AWS</div>
                          <div class="ms-auto fw-semibold me-2">15%</div>
                        </div>
                        <div class="progress-group-bars">
                          <div class="progress progress-thin">
                            <div class="progress-bar bg-success" role="progressbar" style="width: 11%" aria-valuenow="11" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                      </div>
                      
                    </div>
                    <!-- /.col-->
                  </div>
                  <!-- /.row--><br>
                </div>
              </div>
            </div>
            <!-- /.col-->
          </div>
          <!-- /.row-->
     <link href="resources/core_ui/vendors/@coreui/chartjs/css/coreui-chartjs.css" rel="stylesheet">