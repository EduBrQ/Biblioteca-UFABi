import http from './http'

const MidiasEletronicasService = {
  getAll: () => {
    return http.get('/midiasEletronicas')
  },
  getById: id => {
    return http.get(`/midiasEletronicas/${id}`)
  },
  edit: item => {
    return http.put(`/midiasEletronicas/${item.id}`, item)
  },
  create: item => {
    return http.post(`/midiasEletronicas`, item)
  },
  delete: id => {
    return http.delete(`/midiasEletronicas/${id}`)
  },
}

export default MidiasEletronicasService