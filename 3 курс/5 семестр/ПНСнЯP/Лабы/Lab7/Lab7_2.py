from keras.models import model_from_json
import numpy as np
from keras.preprocessing import image

json_file = open("cifar_model.json", "r")
loaded_model_json = json_file.read()
json_file.close()
loaded_model = model_from_json(loaded_model_json)
loaded_model.load_weights("cifar_model.h5")
loaded_model.compile(loss='categorical_crossentropy', optimizer='sgd', metrics=['accuracy'])
print("Загрузили Model")

# ***** Загружаем изображение в Keras:
img_path = 'truck10.png.png'
img = image.load_img(img_path, target_size=(32, 32))
# В отличие от рукописных цифр, в этот раз изображение цветное и его размер 32х32, в соответствии с форматом
# CIFAR-10. Преобразуем картинку в массив numpy:

x = image.img_to_array(img)
x /= 255
x = np.expand_dims(x, axis=0)

# Запускаем распознавание объекта:
prediction = loaded_model.predict(x)
# Для удобства вывода задаем список с названиями классов объектов:

classes = ['самолет', 'автомобиль', 'птица', 'кот', 'олень',
           'собака', 'лягушка', 'лошадь', 'корабль', 'грузовик']
# Печатаем результат распознавания:

print(classes[np.argmax(prediction)])
