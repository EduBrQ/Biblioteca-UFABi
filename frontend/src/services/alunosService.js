import http from './http'

const AlunosService = {
  getAll: () => {
    return http.get('/alunos')
  },
  getById: id => {
    return http.get(`/alunos/${id}`)
  },
  edit: item => {
    return http.put(`/alunos/${item.id}`, item)
  },
  create: item => {
    return http.post(`/alunos`, item)
  }
}

export default AlunosService