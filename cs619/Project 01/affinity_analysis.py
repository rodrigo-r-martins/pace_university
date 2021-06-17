"""
In this example it will be performed the affinity analysis which is the correlation between samples.
It will be done by using product recommendation service based on the fact that some products are likely to be purchased together.
"""

# LOADING AFFINITY DATASET
import numpy as np
dataset_filename = "affinity_dataset.txt"
X = np.loadtxt(dataset_filename)

n_samples, n_features = X.shape     # Checking samples and features
print('===== UNDERSTANDING THE DATASET AFTER HAVE READ IT: =====')
print(f'Samples in dataset = {n_samples}')
print(f'Features in dataset = {n_features}')

print(X[:5])        # Printing five samples to check samples and features
print('')

features = ['bread', 'milk', 'cheese', 'apples', 'bananas']     # Turning numbers of dataset in words


# CHECKING RULE EXAMPLE: "If a person buys Apples, they also buy Bananas"
print('===== CHECKING RULE "IF A PERSON BUYS APPLES, THEY ALSO BUY BANANAS": =====')
num_apple_purchases = 0     # Checking the number of people who bought Apples
rule_valid = 0              # Checking the entire rule
rule_invalid = 0
for sample in X:
    if sample[3] == 1:      # Which means the person bought Apple
        num_apple_purchases += 1
        if sample[4] == 1:  # Which means the person bought Banana as well
            rule_valid += 1
        else:
            rule_invalid += 1
print(f'{num_apple_purchases} people bought Apples')
print(f'{rule_valid} times the rule was valid')
print(f'{rule_invalid} time the rule was invalid')

support_ex = rule_valid                             # support is the number of time rule was considered valid
confidence_ex = rule_valid / num_apple_purchases    # confidence is the number of time rule was considered valid DIVIDED by number of samples where apple occurs
print('--> Rule (Apple | Bananas) result:')
print(f'Support = {support_ex}')
print(f'Confidence = {confidence_ex:.2f} or {confidence_ex*100:.1f}%')
print('')


# SETTING UP DICTIONARIES TO STORE ALL THE RESULTS
from collections import defaultdict
valid_rules = defaultdict(int)
invalid_rules = defaultdict(int)
num_occurrences = defaultdict(int)

for sample in X:
    for premise in range(n_features):       # n_features is the number of columns
        if sample[premise] == 0:
            continue
        num_occurrences[premise] += 1
        for conclusion in range(n_features):
            if premise == conclusion:       # ignore same values
                continue
            if sample[conclusion] == 1:
                valid_rules[(premise, conclusion)] += 1
            else:
                invalid_rules[(premise, conclusion)] += 1

# COMPUTING THE SUPPORT AND CONFIDENCE FOR EACH RULE
support = valid_rules
confidence = defaultdict(float)
for premise, conclusion in valid_rules.keys():
    rule = (premise, conclusion)
    confidence[rule] = valid_rules[rule] / num_occurrences[premise]

# PRINTING ALL POSSIBLE RULES
print('===== PRINTING ALL POSSIBLE RULES: =====')
for premise, conclusion in confidence:
    premise_name = features[premise]
    conclusion_name = features[conclusion]
    rule = (premise, conclusion)
    print(f'Rule: If a person buys {premise_name} they will also buy {conclusion_name}')
    print(f'- Confidence: {confidence[rule]:.3f} or {confidence[rule]*100:.1f}%')
    print(f'- Support: {support[rule]}')
    print('')


# DEFINING PRINT_RULE METHOD
def print_rule(premise, conclusion, support, confidence, features):
    premise_name = features[premise]
    conclusion_name = features[conclusion]
    rule = (premise, conclusion)
    print(f'Rule: If a person buys {premise_name} they will also buy {conclusion_name}')
    print(f' - Support: {support[rule]}')
    print(f' - Confidence: {confidence[rule]:.3f} or {confidence[rule]*100:.1f}%')
    print('')


# RANKING TO FIND THE BEST RULES
from operator import itemgetter

print('===== TOP 5 RULES SORTED BY SUPPORT =====')
sorted_support = sorted(support.items(), key=itemgetter(1), reverse=True)
for index in range(5):
    print(f'Rule #{index+1}')
    (premise, conclusion) = sorted_support[index][0]
    print_rule(premise, conclusion, support, confidence, features)

print('===== TOP 5 RULES SORTED BY CONFIDENCE =====')
sorted_confidence = sorted(confidence.items(), key=itemgetter(1), reverse=True)
for index in range(5):
    print(f'Rule #{index+1}')
    (premise, conclusion) = sorted_confidence[index][0]
    print_rule(premise, conclusion, support, confidence, features)

from matplotlib import pyplot as plt
plt.plot([confidence[rule[0]] for rule in sorted_confidence])
plt.show()



