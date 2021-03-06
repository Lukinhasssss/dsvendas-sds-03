import axios from 'axios'
import { useEffect, useState } from 'react'
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/sale'
import { BASE_URL } from 'utils/requests'

type ChartData = {
  labels: string[]
  series: number[]
}

const DonutChart = () => {
  const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] })

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/amount-by-seller`)
      .then(response => {
        const data = response.data as SaleSum[]
        const labels = data.map(label => label.sellerName)
        const series = data.map(serie => serie.sum)

        setChartData({ labels, series })
      })
  }, [])

  const options = {
    legend: {
      show: true
    }
  }

  // const mockData = {
  //   series: [477138, 499928, 444867, 220426, 473088],
  //   labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
  // }

  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={ chartData.series }
      type="donut"
      height={ 240 }
    />
  )
}

export default DonutChart